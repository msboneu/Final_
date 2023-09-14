import React from "react";

const SearchField = ({
    id,
    type,
    placeholder,
    value,
    onChange,
    className,
}) => {
    return (
        <input
            id={id}
            type={type}
            name={name}
            placeholder={placeholder}
            value={value}
            onChange={onChange}
            className={className}
      />
    )
}

export default SearchField;