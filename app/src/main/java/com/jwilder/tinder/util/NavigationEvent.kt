package com.jwilder.tinder.util

/**
 * Class to handle navigation events
 */
sealed class NavigationEvent {

    /**
     * NavigationEvent to represent navigation to the expanded gif fragment
     */
    object NavigateToExpandedGifFragment : NavigationEvent()
}
