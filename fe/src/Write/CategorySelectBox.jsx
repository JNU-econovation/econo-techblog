import React from 'react';

import './css/CategorySelectBox.css';

function CategorySelectBox() {
  return (
    <select name="category" className="category-select-box">
      <option disabled selected>
        게시판을 선택해주세요
      </option>
      <option value="0">Tech</option>
      <option value="1">Culture</option>
      <option value="2">Trouble Shooting</option>
    </select>
  );
}

export default CategorySelectBox;
