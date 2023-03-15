CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    login    VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role     VARCHAR(50)  NOT NULL,
    created  TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE projects
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(100) NOT NULL,
    created TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE subprojects
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    project_id BIGINT       NOT NULL REFERENCES projects,
    created    TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tasks
(
    id                 BIGSERIAL PRIMARY KEY,
    name               VARCHAR(100) NOT NULL,
    type               VARCHAR(100) NOT NULL,
    status             VARCHAR(100) NOT NULL,
    description        VARCHAR(255) NOT NULL,
    user_id            BIGINT       NOT NULL REFERENCES users,
    subproject_id      BIGINT       NOT NULL REFERENCES subprojects,
    created            TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_change_status TIMESTAMPTZ
);

CREATE TABLE tokens
(
    token   VARCHAR(255) PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users,
    created            TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP
);