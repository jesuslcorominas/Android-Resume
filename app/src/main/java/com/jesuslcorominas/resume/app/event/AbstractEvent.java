package com.jesuslcorominas.resume.app.event;

/**
 * Por el funcionamiento de EventBus, si alguna activity o fragment se registra para un bus
 * debe tener por lo menos un metodo publico anotado Subscribe. Las clases base
 * {@link com.jesuslcorominas.resume.app.view.fragment.BaseFragment} y
 * {@link com.jesuslcorominas.resume.app.view.activity.BaseActivity} se registran para eventos ya que asi
 * todas las acitivities y fragments de la aplicacion estan registradas, pero no todas tienen
 * por que tener un metodo publico anotado como Subscribe. Para evitar el error, BaseFragment y
 * BaseActivity tienen los metodos
 * {@link com.jesuslcorominas.resume.app.view.fragment.BaseFragment#onEvent(AbstractEvent)} y
 * {@link com.jesuslcorominas.resume.app.view.activity.BaseActivity#onEvent(AbstractEvent)} anotados
 * con Subscribe que reciben una instancia de esta clase, pero que al ser abstracta y con un
 * unico constructor privado nunca deberia llegar a ejecutarse.
 *
 * @author Jesús López Corominas
 */
public abstract class AbstractEvent implements Event {

    private AbstractEvent() {

    }
}
