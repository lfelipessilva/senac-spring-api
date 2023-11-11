CREATE TABLE
    discipline (
        id TEXT PRIMARY KEY UNIQUE NOT NULL,
        name TEXT NOT NULL,
        description TEXT NOT NULL,
        workload INTEGER NOT NULL
    );