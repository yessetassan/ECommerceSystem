-- Create the trigger function
CREATE OR REPLACE FUNCTION update_last_modified_at()
RETURNS TRIGGER AS $$
BEGIN
  NEW.last_modified_at = NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create the trigger
CREATE TRIGGER set_last_modified_at
    BEFORE UPDATE ON t_order
    FOR EACH ROW
    EXECUTE FUNCTION update_last_modified_at();