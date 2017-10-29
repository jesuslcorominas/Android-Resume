package com.jesuslcorominas.resume.app.event;

/**
 * Eventos para enviar a traves del bus de eventos (EventBus).
 * <p>
 * Para eliminar el uso de BroadcastReceiver se agrega la libreria EventBus que permite publicar
 * eventos desde una parte de la aplicacion para ser escuchados desde otra.
 * Si por ejemplo queremos comunicar una Activity con sus Fragment, en el fragment tenemos que
 * crear un metodo, llamado como queramos anotado como @link @{@link org.greenrobot.eventbus.Subscribe}
 * que reciba como parametro un objeto simple. Ademas, al agregar el fragment nos registraremos
 * (register) en el bus de eventos y al quitarlo nos desregistramos (unregister).
 * Por ultimo, desde la activity publicaremos el evento (post) a traves del bus de eventos.
 *
 * @author Jesús López Corominas
 * @see <a href="http://greenrobot.org/eventbus/" />
 */
public interface Event {
}
