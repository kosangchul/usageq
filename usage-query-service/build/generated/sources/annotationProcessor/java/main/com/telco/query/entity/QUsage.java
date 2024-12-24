package com.telco.query.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsage is a Querydsl query type for Usage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsage extends EntityPathBase<Usage> {

    private static final long serialVersionUID = 728562288L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsage usage = new QUsage("usage");

    public final QDataUsage dataUsage;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMessageUsage messageUsage;

    public final StringPath userId = createString("userId");

    public final QVideoUsage videoUsage;

    public final QVoiceUsage voiceUsage;

    public QUsage(String variable) {
        this(Usage.class, forVariable(variable), INITS);
    }

    public QUsage(Path<? extends Usage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsage(PathMetadata metadata, PathInits inits) {
        this(Usage.class, metadata, inits);
    }

    public QUsage(Class<? extends Usage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dataUsage = inits.isInitialized("dataUsage") ? new QDataUsage(forProperty("dataUsage")) : null;
        this.messageUsage = inits.isInitialized("messageUsage") ? new QMessageUsage(forProperty("messageUsage")) : null;
        this.videoUsage = inits.isInitialized("videoUsage") ? new QVideoUsage(forProperty("videoUsage")) : null;
        this.voiceUsage = inits.isInitialized("voiceUsage") ? new QVoiceUsage(forProperty("voiceUsage")) : null;
    }

}

