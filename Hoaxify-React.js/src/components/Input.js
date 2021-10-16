import React from "react";

const   Input = (props) => {
    const {label,name,error,onChange,type} = props
    const className= error ? "form-control is-invalid" : "form-control"
  return (
    <div className="mb-3 form-group">
      <label>{label}</label>
      <input
        className={className}
        name={name}
        onChange={onChange}
        type={type}
      />
      <div className="invalid-feedback">{error}</div>
    </div>
  );
};

export default Input;