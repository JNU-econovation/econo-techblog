import React from 'react';

// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';
import './css/CardinalSelectBox.css';

function CardinalSelectBox({ classNames }) {
  // const year = new Date().getFullYear() - 2000;

  return (
    <select name="cardinal" className={`cardinal-select-box ${classNames}`}>
      <option disabled selected>
        기수
      </option>
      <option value="11">11기</option>
      <option value="12">12기</option>
      <option value="13">13기</option>
      <option value="14">14기</option>
      <option value="15">15기</option>
      <option value="16">16기</option>
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

CardinalSelectBox.propTypes = {
  classNames: PropTypes.string.isRequired,
};

export default CardinalSelectBox;
