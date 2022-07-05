/* eslint-disable object-curly-newline */
import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import './css/InputElement.css';

function InputElement({ placeHolder, classNames, value, setValue, type }) {
  const onChange = (e) => {
    setValue(() => e.target.value);
  };
  return (
    <div className="box-element">
      <input
        className={classNames}
        placeholder={placeHolder}
        value={value}
        onChange={onChange}
        type={type}
      />
    </div>
  );
}

InputElement.propTypes = {
  placeHolder: PropTypes.string.isRequired,
  classNames: PropTypes.string.isRequired,
  value: PropTypes.string.isRequired,
  setValue: PropTypes.func.isRequired,
  type: PropTypes.string.isRequired,
};
export default InputElement;
