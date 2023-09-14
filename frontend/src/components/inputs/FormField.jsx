import React from "react";

const FormField = ({
  id,
  name,
  label,
  placeholder,
  value,
  error,
  type,
  onChange,
}) => {
  return (
    <div className="form-group">
      <label className="form-control-label">{label}</label>
      <input
        type={type}
        id={id}
        name={name}
        placeholder={placeholder}
        className={`form-control ${error ? "is-invalid" : ""}`}
        value={value}
        onChange={onChange}
      />
      {error && <div className="invalid-feedback">{error}</div>}
    </div>
  );
};

export default FormField;