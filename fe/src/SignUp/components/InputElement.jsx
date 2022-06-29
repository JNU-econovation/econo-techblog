import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import '../css/InputElement.css';

function InputElement({ placeHolder, classNames }) {
  return (
    <div className="box-element">
      <input className={classNames} placeholder={placeHolder} />
    </div>
  );
}

InputElement.propTypes = {
  placeHolder: PropTypes.string.isRequired,
  classNames: PropTypes.string.isRequired,
};
export default InputElement;
