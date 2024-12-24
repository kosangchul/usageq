package com.telco.query.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMessageUsage is a Querydsl query type for MessageUsage
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMessageUsage extends BeanPath<MessageUsage> {

    private static final long serialVersionUID = -736901589L;

    public static final QMessageUsage messageUsage = new QMessageUsage("messageUsage");

    public final NumberPath<Long> excessUsage = createNumber("excessUsage", Long.class);

    public final NumberPath<Long> freeUsage = createNumber("freeUsage", Long.class);

    public final NumberPath<Long> totalUsage = createNumber("totalUsage", Long.class);

    public QMessageUsage(String variable) {
        super(MessageUsage.class, forVariable(variable));
    }

    public QMessageUsage(Path<? extends MessageUsage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMessageUsage(PathMetadata metadata) {
        super(MessageUsage.class, metadata);
    }

}

