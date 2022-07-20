import React, { useState, useEffect } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';
import Pagination from 'react-js-pagination';

import '../css/SearchResult.css';
import SearchNavItem from './SearchNavItem';
import Recent from '../../Tech/components/Recent';

const SearchResult = function ({ keyword }) {
  const [movies, setMovies] = useState([]);
  const getMovies = async () => {
    const response = await fetch(
      'https://yts.mx/api/v2/list_movies.json?minimum_rating=9&sort_by=year',
    );
    const json = await response.json();
    setMovies(json.data.movies);
  };
  useEffect(() => {
    getMovies();
  }, []);
  const [currentPage, setCurrentPage] = useState(1);
  const postPerPage = 5;
  const indexOfLast = currentPage * postPerPage;
  const indexOfFirst = indexOfLast - postPerPage;
  const currentPosts = (posts) => {
    let slicePosts = 0;
    slicePosts = posts.slice(indexOfFirst, indexOfLast);
    return slicePosts;
  };
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
      <div>
        {currentPosts(movies).map((item) => (
          <Recent
            key={item.id}
            id={item.id}
            title={item.title}
            summary={item.summary}
          />
        ))}
        <Pagination
          activePage={currentPage}
          itemsCountPerPage={5}
          totalItemsCount={movies.length}
          pageRangeDisplayed={3}
          prevPageText="<"
          nextPageText=">"
          onChange={setCurrentPage}
        />
      </div>
    </div>
  );
};

SearchResult.propTypes = {
  keyword: PropTypes.string.isRequired,
};

export default SearchResult;
