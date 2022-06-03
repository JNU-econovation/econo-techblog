import { React, useState } from 'react';

import SearchInput from './SearchInput';
import searchButton from '../img/search_button.png';

function Search() {
  const [isSearchOn, setIsSearchOn] = useState(false);
  const onClick = () => {
    setIsSearchOn(!isSearchOn);
  };

  return (
    <>
      {isSearchOn && <SearchInput />}
      <button type="button" onClick={onClick}>
        <img alt="search-button" src={searchButton} />
      </button>
    </>
  );
}

export default Search;
