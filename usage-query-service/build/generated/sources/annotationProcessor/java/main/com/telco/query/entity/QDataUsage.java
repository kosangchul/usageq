package com.telco.query.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDataUsage is a Querydsl query type for DataUsage
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QDataUsage extends BeanPath<DataUsage> {

    private static final long serialVersionUID = 441931110L;

    public static final QDataUsage dataUsage = new QDataUsage("dataUsage");

    public final NumberPath<Long> excessUsage = createNumber("excessUsage", Long.class);

    public final NumberPath<Long> freeUsage = createNumber("freeUsage", Long.class);

    public final NumberPath<Long> totalUsage = createNumber("totalUsage", Long.class);

    public QDataUsage(String variable) {
        super(DataUsage.class, forVariable(variable));
    }

    public QDataUsage(Path<? extends DataUsage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDataUsage(PathMetadata metadata) {
        super(DataUsage.class, metadata);
    }

}

