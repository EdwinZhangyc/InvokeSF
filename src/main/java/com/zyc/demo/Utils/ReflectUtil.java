package com.zyc.demo.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public final class ReflectUtil {
	private static final Logger log = LoggerFactory.getLogger(ReflectUtil.class);

	/**
	 * @Method: respTransmission
	 * @Description: 反射对应变量赋值
	 * @param source
	 *            源
	 * @param target
	 *            目标
	 * @return
	 */
	public static final <T, R> T respTransmission(R source, T target) {

		for (Field f : target.getClass().getDeclaredFields()) {

			f.setAccessible(true);
			try {

				Field t = source.getClass().getDeclaredField(f.getName());
				if (f.getType() != t.getType()) {
					log.info("类型不匹配{}-{}", f.getType(), t.getType());
					continue;
				}
				t.setAccessible(true);

				f.set(target, t.get(source));
			} catch (NoSuchFieldException e) {
				log.error("未找到字段{}", f.getName());
			} catch (SecurityException e) {
				log.error("无法访问字段{}", f.getName());
			} catch (IllegalArgumentException e ) {
				log.error("对字段赋值失败{},{}", f.getName(), e.getMessage());
			} catch (IllegalAccessException e) {
				log.error("对字段赋值失败{},{}", f.getName(), e.getMessage());
			}

		}

		return target;
	}

}
