import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import search from '../img/search.png';
import '../css/TagSearch.css';

const TagSearch = function ({ setValue, value }) {
  const onChange = (e) => {
    setValue(() => e.target.value);
  };
  return (
    <div className="tag-search">
      <input className="tag-search__input" onChange={onChange} value={value} />
      <img src={search} alt="search" className="tag-search__img" />
    </div>
  );
};

TagSearch.propTypes = {
  setValue: PropTypes.func.isRequired,
  value: PropTypes.string.isRequired,
};

export default TagSearch;
