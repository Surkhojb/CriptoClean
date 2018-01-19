package com.clean.juanjo.presentation.settingsfragment;

/**
 * Created by juanj on 16/01/2018.
 */

public interface SettingsFragmentContract {
    interface View{
        void showMessage(String message);
        void showError(String errorMessage);
    }
    interface Presenter{
        void saveSettings(String numberOfItems);
    }
}
