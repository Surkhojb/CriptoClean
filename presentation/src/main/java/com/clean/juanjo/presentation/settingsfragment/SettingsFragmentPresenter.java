package com.clean.juanjo.presentation.settingsfragment;

import com.clean.juanjo.domain.interactor.DefaultObserver;
import com.clean.juanjo.domain.interactor.SaveSettingsUseCase;
import javax.inject.Inject;

/**
 * Created by juanj on 16/01/2018.
 */

public class SettingsFragmentPresenter implements SettingsFragmentContract.Presenter {

    @Inject
    SettingsFragmentContract.View view;

    @Inject
    SaveSettingsUseCase saveSettings;

    @Inject
    public SettingsFragmentPresenter(){}

    @Override
    public void saveSettings(String numberOfItems) {
        saveSettings.execute(new SettingsObserver(), SaveSettingsUseCase.Params.create(numberOfItems));
    }

    final class SettingsObserver extends DefaultObserver<Boolean> {

        @Override
        public void onNext(Boolean aBoolean) {
            if(aBoolean)
                view.showMessage("Changes saved!");
            else
                view.showError("Error saving changes.");

        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            view.showError(exception.getLocalizedMessage());
        }
    }
}
