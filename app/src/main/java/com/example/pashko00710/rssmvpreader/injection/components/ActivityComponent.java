package com.example.pashko00710.rssmvpreader.injection.components;import com.example.pashko00710.rssmvpreader.injection.ActivityScope;import com.example.pashko00710.rssmvpreader.injection.modules.ActivityModule;import com.example.pashko00710.rssmvpreader.ui.MainActivity;import dagger.Component;@ActivityScope@Component(        dependencies = ApplicationComponent.class,        modules = ActivityModule.class)public interface ActivityComponent {    void inject(MainActivity activity);}