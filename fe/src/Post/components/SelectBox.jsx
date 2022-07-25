import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import '../css/SelectBox.css';
import edit from '../img/edit.png';
import trash from '../img/trash.png';

const SelectBox = function ({ onDelete }) {
  return (
    <div className="select-box">
      <button type="button" className="select-box-eidt__button">
        <span>수정하기</span>
        <img src={edit} alt="edit" />
      </button>
      <button
        onClick={onDelete}
        type="button"
        className="select-box-delete__button"
      >
        <span>삭제하기</span>
        <img src={trash} alt="trash" />
      </button>
    </div>
  );
};

SelectBox.propTypes = {
  onDelete: PropTypes.func.isRequired,
};

export default SelectBox;
