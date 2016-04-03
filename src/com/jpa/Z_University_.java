package com.jpa;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;


@javax.persistence.metamodel.StaticMetamodel
(value=com.jpa.Z_University.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Sun Apr 3 08:26:23 EDT 2016")
public class Z_University_ {
	public static volatile SingularAttribute<Z_University,String> uni_id;
	public static volatile SingularAttribute<Z_University,String> name;
	public static volatile SingularAttribute<Z_University,String> city;
	public static volatile SingularAttribute<Z_University,String> state;
	public static volatile SetAttribute<Z_University,String> students;
	public static volatile SetAttribute<Z_University,String> professors;
}
