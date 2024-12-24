package com.telco.query.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseUsage is a Querydsl query type for BaseUsage
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseUsage extends EntityPathBase<BaseUsage> {

    private static final long serialVersionUID = -1011114337L;

    public static final QBaseUsage baseUsage = new QBaseUsage("baseUsage");

    public final NumberPath<Long> excessUsage = createNumber("excessUsage", Long.class);

    public final NumberPath<Long> freeUsage = createNumber("freeUsage", Long.class);

    public final NumberPath<Long> totalUsage = createNumber("totalUsage", Long.class);

    public QBaseUsage(String variable) {
        super(BaseUsage.class, forVariable(variable));
    }

    public QBaseUsage(Path<? extends BaseUsage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseUsage(PathMetadata metadata) {
        super(BaseUsage.class, metadata);
    }

}

