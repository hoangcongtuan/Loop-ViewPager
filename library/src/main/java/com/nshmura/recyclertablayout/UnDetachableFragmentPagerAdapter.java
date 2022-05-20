package com.nshmura.recyclertablayout;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * FragmentPagerAdapter ではフラグメントを切り替えるときに、
 * そのインスタンスを detach / attach するが、このアダプタでは hide / show で扱う。
 */
public abstract class UnDetachableFragmentPagerAdapter extends CustomPagerAdapter {
    private static final String TAG = "UnDetachableFragmentPagerAdapter";
    private static final boolean DEBUG = false;

    private final FragmentManager mFragmentManager;
    private FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;

    public UnDetachableFragmentPagerAdapter(FragmentManager fm) {
        mFragmentManager = fm;
    }

    /**
     * Return the Fragment associated with a specified position.
     */
    public abstract Fragment getItem(int position);

    @Override
    public void startUpdate(ViewGroup container) {
        if (container.getId() == View.NO_ID) {
            throw new IllegalStateException(
                    "ViewPager with adapter " + this + " requires a view id");
        }
    }

    private Handler handler = new Handler(Looper.getMainLooper());

    @SuppressWarnings("ReferenceEquality")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (mCurTransaction == null) {
            mCurTransaction = mFragmentManager.beginTransaction();
        }

        final long itemId = getItemId(position);

        // Do we already have this fragment?
        String name = makeFragmentName(container.getId(), itemId);
        Fragment fragment = mFragmentManager.findFragmentByTag(name);
        if (fragment != null) {
            if (DEBUG) Log.v(TAG, "Attaching item #" + itemId + ": f=" + fragment);
            mCurTransaction.show(fragment); // NOTE: attach せずに show する
        } else {
            fragment = getItem(position);
            if (DEBUG) Log.v(TAG, "Adding item #" + itemId + ": f=" + fragment);
            mCurTransaction.add(container.getId(), fragment,
                    makeFragmentName(container.getId(), itemId));
        }
        if (fragment != mCurrentPrimaryItem) {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        }

        /*Fragment finalFragment = fragment;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mCurTransaction == null) {
                    mCurTransaction = mFragmentManager.beginTransaction();
                }
                Fragment fragment1;
                fragment1 = getItem(position);
                mCurTransaction.add(container.getId(), fragment1,
                        makeFragmentName(container.getId(), itemId));
//                mCurTransaction.show(fragment1);
                mCurTransaction.commit();
                mCurTransaction = null;
            }
        }, 2000);*/
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (mCurTransaction == null) {
            mCurTransaction = mFragmentManager.beginTransaction();
        }
        if (DEBUG) {
            Log.v(TAG, "Detaching item #"
                    + getItemId(position)
                    + ": f="
                    + object
                    + " v="
                    + ((Fragment) object).getView());
        }
        mCurTransaction.hide((Fragment) object); // NOTE: detach せずに hide する
        // Fragment が3つの場合に ViewPager.populate が呼ばれると表示すべきページの Fragment を消してしまうのですぐに show してあげる
        mCurTransaction.show((Fragment) object);
    }

    @SuppressWarnings("ReferenceEquality")
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment) object;
        if (fragment != mCurrentPrimaryItem) {
            if (mCurrentPrimaryItem != null) {
                mCurrentPrimaryItem.setMenuVisibility(false);
                mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            mCurrentPrimaryItem = fragment;
        }
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        if (mCurTransaction != null) {
            mCurTransaction.commitNowAllowingStateLoss();
            mCurTransaction = null;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return ((Fragment) object).getView() == view;
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    /**
     * Return a unique identifier for the item at the given position.
     *
     * <p>The default implementation returns the given position.
     * Subclasses should override this method if the positions of items can change.</p>
     *
     * @param position Position within this adapter
     * @return Unique identifier for the item at position
     */
    public long getItemId(int position) {
        return position;
    }

    private static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }
}