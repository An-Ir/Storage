-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA storage CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA storage
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA storage TO postgres;
GRANT ALL ON SCHEMA storage TO PUBLIC;