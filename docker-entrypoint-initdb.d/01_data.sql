INSERT INTO users(login, password, role)
VALUES ('artemka',
        '$2a$10$FdY4iOI561GrE8oSwHxDO.O3Jv2wcQKBSNKnvMgjouath5jS9fkn2',
        'ADMIN');

INSERT INTO users(login, password, role)
VALUES ('kostya',
        '$2a$10$FdY4iOI561GrE8oSwHxDO.O3Jv2wcQKBSNKnvMgjouath5jS9fkn2',
        'SIMPLE_USER');

INSERT INTO projects(name)
VALUES ('bank_manager');

INSERT INTO subprojects(name, project_id)
VALUES ('credit_manager', 1);

INSERT INTO tasks(name, type, status, description, user_id,
                  subproject_id)
VALUES ('do tests',
        'tech_specialist',
        'progress',
        'do all unit tests',
        2,
        1);

INSERT INTO tokens(token, user_id)
VALUES ('abc', 1)