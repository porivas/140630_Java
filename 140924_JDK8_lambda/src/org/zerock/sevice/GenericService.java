package org.zerock.sevice;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * This interface use static methods to generic type's service
 * 
 * if you want to add other methods extends this
 * 
 * @author Zerock
 *
 * @param <T> VO type
 * @param <K> Pirmary key type
 */
public interface GenericService<T,K>{

	public static<T> void regist(T vo, Consumer<T> consumer)throws Exception{
		consumer.accept(vo);
	}
	
	public static<T,K> T read(K key, Function<K, T> fn)throws Exception{
		return fn.apply(key);
	}
	
	public static<T> void modify(T vo, Consumer<T> consumer)throws Exception{
		
		consumer.accept(vo);
	}
	
	public static<K> void remove(K key, Consumer<K> consumer)throws Exception{
		
		consumer.accept(key);
		
	}
	
}
