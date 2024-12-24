package com.telco.query.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVideoUsage is a Querydsl query type for VideoUsage
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QVideoUsage extends BeanPath<VideoUsage> {

    private static final long serialVersionUID = -2144978313L;

    public static final QVideoUsage videoUsage = new QVideoUsage("videoUsage");

    public final NumberPath<Long> excessUsage = createNumber("excessUsage", Long.class);

    public final NumberPath<Long> freeUsage = createNumber("freeUsage", Long.class);

    public final NumberPath<Long> totalUsage = createNumber("totalUsage", Long.class);

    public QVideoUsage(String variable) {
        super(VideoUsage.class, forVariable(variable));
    }

    public QVideoUsage(Path<? extends VideoUsage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVideoUsage(PathMetadata metadata) {
        super(VideoUsage.class, metadata);
    }

}

