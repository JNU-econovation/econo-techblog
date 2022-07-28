/* eslint-disable */
import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import '../css/SearchNavItem.css';

const SearchNavItem = function ({ id, active, name, num, onClick }) {
  return (
    <div
      className={
        active ? 'search-nav-item search-nav-item--active' : 'search-nav-item'
      }
      onClick={() => onClick(id)}
    >
      {`${name}(${num})`}
    </div>
  );
};

SearchNavItem.propTypes = {
  id: PropTypes.number.isRequired,
  active: PropTypes.bool.isRequired,
  name: PropTypes.string.isRequired,
  num: PropTypes.number.isRequired,
  onClick: PropTypes.func.isRequired,
};

export default SearchNavItem;
