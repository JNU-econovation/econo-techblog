/* eslint-disable object-curly-newline */
import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import './css/InputElement.css';

function InputElement({ placeHolder, classNames, value, setValue }) {
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
      />
    </div>
  );
}

InputElement.propTypes = {
  placeHolder: PropTypes.string.isRequired,
  classNames: PropTypes.string.isRequired,
  value: PropTypes.string.isRequired,
  setValue: PropTypes.func.isRequired,
};
export default InputElement;
