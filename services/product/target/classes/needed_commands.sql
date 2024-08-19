DO $$ DECLARE
r RECORD;
BEGIN
    -- tables
FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = current_schema()) LOOP
            EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE';
END LOOP;

    -- views
FOR r IN (SELECT viewname FROM pg_views WHERE schemaname = current_schema()) LOOP
            EXECUTE 'DROP VIEW IF EXISTS ' || quote_ident(r.viewname) || ' CASCADE';
END LOOP;

    -- sequences
FOR r IN (SELECT sequencename FROM pg_sequences WHERE schemaname = current_schema()) LOOP
            EXECUTE 'DROP SEQUENCE IF EXISTS ' || quote_ident(r.sequencename) || ' CASCADE';
END LOOP;

    -- functions
FOR r IN (SELECT routine_name FROM information_schema.routines WHERE specific_schema = current_schema()) LOOP
            EXECUTE 'DROP FUNCTION IF EXISTS ' || quote_ident(r.routine_name) || ' CASCADE';
END LOOP;

    -- indexes
FOR r IN (SELECT indexname FROM pg_indexes WHERE schemaname = current_schema()) LOOP
            EXECUTE 'DROP INDEX IF EXISTS ' || quote_ident(r.indexname) || ' CASCADE';
END LOOP;
END $$;
