package com.jesuslcorominas.resume.data.di.module;

import org.modelmapper.ModelMapper;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module
public class MapperModule {

    @Provides
    ModelMapper provideModelMapper() {
        ModelMapper mapper = new ModelMapper();

        return mapper;
    }
}
