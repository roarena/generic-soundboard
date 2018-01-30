package eu.rodrigocamara.genericsoundboard;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
