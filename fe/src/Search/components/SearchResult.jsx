import React, { useState, useEffect } from 'react';
// import { useParams } from 'react-router-dom';
import Pagination from 'react-js-pagination';
import { gql, useQuery } from '@apollo/client';

import '../css/SearchResult.css';
import '../../components/css/Pagination.css';
import SearchNavItem from './SearchNavItem';
import PostBox from '../../components/PostBox';

const GET_SEARCH = gql`
  query getSearch($currentKeyword: String!, $page: Int!) {
    search(keyword: $currentKeyword, page: $page) {
      id
      userId
      content
      title
      official
      views
      hearts
      mainCategoryNumber
    }
  }
`;

const SearchResult = function () {
  // const { currentKeyword } = useParams();
  const currentKeyword = 'C++';
  const [currentPage, setCurrentPage] = useState(1);
  const postPerPage = 5;
  const indexOfLast = currentPage * postPerPage;
  const indexOfFirst = indexOfLast - postPerPage;
  const currentPosts = (posts) => {
    let slicePosts = 0;
    slicePosts = posts.slice(indexOfFirst, indexOfLast);
    return slicePosts;
  };
  const result = useQuery(GET_SEARCH, {
    variables: {
      keyword: currentKeyword,
      page: currentPage,
    },
  });
  console.log(result);
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
  const postNum = [5, 3, 0, 2]; // 검색 결과
  return (
    <div className="search-result">
      <div className="search-result__text">
        <span className="search-result__keyword">{currentKeyword}</span>
        <span className="search-result__num">{`검색결과 (총 ${result[0]}건)`}</span>
      </div>
      <div className="search-result__nav">
        {navArr.map((elem) => (
          <SearchNavItem
            key={elem.id}
            id={elem.id}
            name={elem.name}
            num={postNum[elem.id - 1]}
            active={elem.active}
            onClick={onClick}
          />
        ))}
      </div>
      <div>
        {currentPosts(movies).map((item) => (
          <PostBox
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

export default SearchResult;
