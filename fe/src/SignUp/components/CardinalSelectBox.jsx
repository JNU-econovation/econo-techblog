import React from 'react';

import '../css/CardinalSelectBox.css';

function CardinalSelectBox() {
  // const year = new Date().getFullYear() - 2000;

  return (
    <select name="cardinal" className="cardinal-select-box">
      <option disabled selected>
        기수
      </option>
      <option value="17">17기</option>
      <option value="18">18기</option>
      <option value="19">19기</option>
      <option value="20">20기</option>
      <option value="21">21기</option>
      <option value="22">22기</option>
      <option value="23">23기</option>
    </select>
  );
}

export default CardinalSelectBox;
