package org.litespring.v4;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.core.annotation.AnnotationAttributes;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.type.classreading.AnnotationMetadataReadingVisitor;
import org.litespring.core.type.classreading.ClassMetadataReadingVisitor;
import org.springframework.asm.ClassReader;

import java.io.IOException;


public class ClassReaderTest {

	@Test
	public void testGetClasMetaData() throws IOException {
		ClassPathResource resource = new ClassPathResource("org/litespring/service/v4/PetStoreService.class");
		ClassReader reader = new ClassReader(resource.getInputStream());

		ClassMetadataReadingVisitor visitor = new ClassMetadataReadingVisitor();

		reader.accept(visitor, ClassReader.SKIP_DEBUG);

		Assert.assertFalse(visitor.isAbstract());
		Assert.assertFalse(visitor.isInterface());
		Assert.assertFalse(visitor.isFinal());
		Assert.assertEquals("org.litespring.service.v4.PetStoreService", visitor.getClassName());
		Assert.assertEquals("java.lang.Object", visitor.getSuperClassName());
		Assert.assertEquals(0, visitor.getInterfaceNames().length);
	}

	@Test
	public void testGetAnnonation() throws Exception{
		ClassPathResource resource = new ClassPathResource("org/litespring/service/v4/PetStoreService.class");
		ClassReader reader = new ClassReader(resource.getInputStream());

		AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor();

		reader.accept(visitor, ClassReader.SKIP_DEBUG);

		String annotation = "org.litespring.stereotype.Component";
		String annotation2 = "org.litespring.stereotype.TestMy";
		Assert.assertTrue(visitor.hasAnnotation(annotation));
		Assert.assertTrue(visitor.hasAnnotation(annotation2));

		AnnotationAttributes attributes = visitor.getAnnotationAttributes(annotation);
		AnnotationAttributes attributes2 = visitor.getAnnotationAttributes(annotation2);

		Assert.assertEquals("petStore", attributes.get("value"));
		Assert.assertEquals("hahaha", attributes2.get("value"));

	}


}
