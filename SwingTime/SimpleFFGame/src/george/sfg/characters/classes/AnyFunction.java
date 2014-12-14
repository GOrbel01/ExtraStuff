package george.sfg.characters.classes;

/**
 * Created by Squall on 09/12/2014.
 */
@FunctionalInterface
public interface AnyFunction<T, G> {

    G func(T t);

}
