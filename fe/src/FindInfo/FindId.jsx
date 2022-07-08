import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import CardinalSelectBox from '../components/CardinalSelectBox';
import InputElement from '../components/InputElement';
import FindIdBtn from './FindIdBtn';

function FindId({ name, setName }) {
  return (
    <div>
      <InputElement
        placeHolder="이름"
        value={name}
        setValue={setName}
        type="text"
      />
      <CardinalSelectBox />
      <FindIdBtn />
    </div>
  );
}

FindId.propTypes = {
  name: PropTypes.string.isRequired,
  setName: PropTypes.func.isRequired,
};

export default FindId;
