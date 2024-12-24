package com.telco.query.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVoiceUsage is a Querydsl query type for VoiceUsage
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QVoiceUsage extends BeanPath<VoiceUsage> {

    private static final long serialVersionUID = -2041984992L;

    public static final QVoiceUsage voiceUsage = new QVoiceUsage("voiceUsage");

    public final NumberPath<Long> excessUsage = createNumber("excessUsage", Long.class);

    public final NumberPath<Long> freeUsage = createNumber("freeUsage", Long.class);

    public final NumberPath<Long> totalUsage = createNumber("totalUsage", Long.class);

    public QVoiceUsage(String variable) {
        super(VoiceUsage.class, forVariable(variable));
    }

    public QVoiceUsage(Path<? extends VoiceUsage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVoiceUsage(PathMetadata metadata) {
        super(VoiceUsage.class, metadata);
    }

}

