package com.clean.juanjo.criptoclean.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by juanj on 11/01/2018.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
