import React from 'react';
import '../css/SelectBox.css';

import edit from '../img/edit.png';
import trash from '../img/trash.png';

const SelectBox = function () {
  return (
    <div className="select-box">
      <button type="button" className="select-box-eidt__button">
        <span>수정하기</span>
        <img src={edit} alt="edit" />
      </button>
      <button type="button" className="select-box-delete__button">
        <span>삭제하기</span>
        <img src={trash} alt="trash" />
      </button>
    </div>
  );
};

export default SelectBox;
