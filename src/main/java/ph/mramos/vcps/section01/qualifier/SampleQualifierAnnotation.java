package ph.mramos.vcps.section01.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("sampleQualifier")
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE  })
@Retention(RetentionPolicy.RUNTIME)
public @interface SampleQualifierAnnotation {

}
