import { useState } from 'react';

import SearchInput from './SearchInput.js';
import search_button from '../img/search_button.png';
const Search = () =>{
    const [isSearchOn, setIsSearchOn] = useState(false);
    const onClick = () => { setIsSearchOn(!isSearchOn); };
    
    return (
        <>
        {isSearchOn && <SearchInput />}
        <button onClick={onClick}><img alt="search-button" src={search_button}/></button>
        </>
    );
}

export default Search;
