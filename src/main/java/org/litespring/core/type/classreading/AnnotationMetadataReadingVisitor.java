package org.litespring.core.type.classreading;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.litespring.core.annotation.AnnotationAttributes;
import org.litespring.core.type.AnnotationMetadata;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.Type;

/**
 * 封装一个对象，所拥有注解和它对应的属性、属性值
 */
public class AnnotationMetadataReadingVisitor extends ClassMetadataReadingVisitor implements  AnnotationMetadata {

	private final Set<String> annotationSet = new LinkedHashSet<String>(4);
	private final Map<String, AnnotationAttributes> attributeMap = new LinkedHashMap<String, AnnotationAttributes>(4);

	public AnnotationMetadataReadingVisitor() {

	}

	/**
	 * asm回调 获取注解属性
	 * @param desc
	 * @param visible
	 * @return
	 */
	@Override
	public AnnotationVisitor visitAnnotation(final String desc, boolean visible) {
		//获取注解的类名
		String className = Type.getType(desc).getClassName();
		this.annotationSet.add(className);
		return new AnnotationAttributesReadingVisitor(className, this.attributeMap);
	}
	public Set<String> getAnnotationTypes() {
		return this.annotationSet;
	}

	public boolean hasAnnotation(String annotationType) {
		return this.annotationSet.contains(annotationType);
	}

	/**
	 * 根据注解类型获取注解的属性键值对
	 * @param annotationType 封装键值对的map
	 * @return
	 */
	public AnnotationAttributes getAnnotationAttributes(String annotationType) {
		return this.attributeMap.get(annotationType);
	}



}
