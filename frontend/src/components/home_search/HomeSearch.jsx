import React, { useState } from 'react';
import styles from "./HomeSearch.module.css"
import { Link } from 'react-router-dom';
import SearchField from '../inputs/SearchField';
import Button from '../buttons/Button';

const HomeSearch = ({ setSearchParams, searchTitle, searchDescription, backgroundImage, searchParams = {} }) => {

  const [keywords, setKeywords] = useState(searchParams.keywords || '');
  const [location, setLocation] = useState(searchParams.location || ''); 

  const handleSearch = () => {
    const searchParams = { keywords, location };
    setSearchParams(searchParams);
  };

  return (
    <div className={styles.home_search} style={{ backgroundImage: `url(${backgroundImage})` }}>
      <h3 className={styles.home_search_header}>{searchTitle}</h3>
      <p className={styles.home_search_description}>{searchDescription}</p>
      <SearchField 
        type="text"
        placeholder="Paseo, relajación, playa, monumentos"
        className={styles.search_input}
        value={keywords}
        onChange={(e) => setKeywords(e.target.value)}
      />
      <SearchField 
        type="text"
        placeholder="Ubicación"
        className={styles.location_input}
        value={location}
        onChange={(e) => setLocation(e.target.value)}
      />
      <Link
        to={{
          pathname: "/categories",
          search: `?keywords=${encodeURIComponent(keywords)}&location=${encodeURIComponent(location)}`,
          state: { searchParams },
        }}
      >
        <Button 
          className={styles.search_btn}
          onClick={handleSearch}
          label="BUSCAR"
        />
      </Link>
  </div>
  );
};

export default HomeSearch;