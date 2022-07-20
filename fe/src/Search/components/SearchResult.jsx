import React, { useState } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import '../css/SearchResult.css';
import SearchNavItem from './SearchNavItem';

const SearchResult = function ({ keyword }) {
  const [navArr, setArr] = useState([
    {
      id: 1,
      name: '전체',
      active: true,
    },
    {
      id: 2,
      name: 'Tech',
      active: false,
    },
    {
      id: 3,
      name: 'Culture',
      active: false,
    },
    {
      id: 4,
      name: 'Trouble Shooting',
      active: false,
    },
  ]);
  const onClick = (id) => {
    setArr(
      navArr.map((item) => {
        const elem = item;
        if (elem.id === id) {
          elem.active = true;
        } else {
          elem.active = false;
        }
        return elem;
      }),
    );
  };
  const result = [5, 3, 0, 2]; // 검색 결과
  return (
    <div className="search-result">
      <div className="search-result__text">
        <span className="search-result__keyword">{keyword}</span>
        <span className="search-result__num">{`검색결과 (총 ${result[0]}건)`}</span>
      </div>
      <div className="search-result__nav">
        {navArr.map((elem) => (
          <SearchNavItem
            key={elem.id}
            id={elem.id}
            name={elem.name}
            num={result[elem.id - 1]}
            active={elem.active}
            onClick={onClick}
          />
        ))}
      </div>
    </div>
  );
};

SearchResult.propTypes = {
  keyword: PropTypes.string.isRequired,
};

export default SearchResult;
