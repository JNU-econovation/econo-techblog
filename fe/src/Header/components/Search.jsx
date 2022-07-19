import React, { useState } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies

import searchButton from '../img/search_button.png';
import './Search.css';

function Search() {
  const [isSearchBarOn, setIsSearchBarOn] = useState(false);
  const onClick = () => {
    setIsSearchBarOn(() => !isSearchBarOn);
  };

  return (
    <div>
      {isSearchBarOn ? (
        <div className="search">
          <input
            className="search-input"
            placeholder="검색어를 입력하세요..."
          />
          <button className="search-button" type="button" onClick={onClick}>
            <img
              className="search-button-img"
              alt="search-button"
              src={searchButton}
            />
          </button>
        </div>
      ) : (
        <div className="search">
          <button
            className="search__button--inactive"
            type="button"
            onClick={onClick}
          >
            <img
              className="search-button__img--inactive"
              alt="search-button"
              src={searchButton}
            />
          </button>
        </div>
      )}
    </div>
  );
}

export default Search;
