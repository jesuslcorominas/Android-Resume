package com.jesuslcorominas.resume.app.util;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Bean de preferencias de Android Annotations.
 * <p>
 * Al anotar la clase como @{@link SharedPref}, unicamente tenemos que crear los metodos que devuelvan
 * el tipo de preferencia y con el nombre de la preferencia. Despues, para obtener el valor, llamaremos
 * a esos metodos. Para establecer el valor, llamaremos a Preferences.edit().[MI_METODO(miValor)].apply()
 * Al obtener la instancia de esta clase, tenemos que obtener la clase extendida, es decir {@link Preferences_}
 *
 * @author Jesus Lopez Corominas
 * @see <a href="https://github.com/androidannotations/androidannotations/wiki/SharedPreferencesHelpers" />
 */
@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface Preferences {

}
