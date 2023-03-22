package com.es.library

import androidx.fragment.app.FragmentActivity

object PermissionX {

    val TAG = "InvisibleFragment"

    fun request(
        fragmentActivity: FragmentActivity,
        vararg permissions: String,
        permissionCallback: PermissionCallback
    ) {
        val tagFragment = fragmentActivity.supportFragmentManager.findFragmentByTag(TAG)
        val holderFragment = if (tagFragment != null) {
            tagFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmentActivity.supportFragmentManager.beginTransaction().add(invisibleFragment, TAG)
                .commitNow()
            invisibleFragment
        }
        holderFragment.requestNow(permissionCallback, *permissions)
    }

}